import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParserFactory;

/**
 * Taken from studres and modified.
 * Retrieves info from openweathermap.org and
 * process it as necessary.
 */
public class RESTClient {

    private static final int MAXIMUM_NUMBER_OF_DAYS = 5;//used for 5-day forecast
    private final boolean OPTION_IS_WEATHER;

    private StatusType status;
    private String result = "";
    private double[] temps = new double[ MAXIMUM_NUMBER_OF_DAYS ];//save degrees when doing graph representation
    private int[] scaledTemps;
    private boolean successfulRetrieve = false;
    private String targetURL = "http://api.openweathermap.org/data/2.5/";

    private String makeRESTCall ( String strURL ) throws MalformedURLException, IOException {

        URL url = new URL ( strURL );

        HttpURLConnection conn = (HttpURLConnection) url.openConnection ();
        //Specify that we are expecting JSON data to be returned
        conn.setRequestMethod ( "GET" );
        conn.setRequestProperty ( "Accept", "application/json" );

        //Create reader to read response from the server
        BufferedReader br = new BufferedReader ( new InputStreamReader ( ( conn.getInputStream () ) ) );

        //Using a StringBuilder is more time and memory efficient, when the size of the concatenated String could be very large
        StringBuilder buffer = new StringBuilder ();
        String output;
        while ( ( output = br.readLine () ) != null )
            buffer.append ( output );
        conn.disconnect ();

        return buffer.toString ();

    }

    private void retrieveInfo () {

        try {
            result = this.makeRESTCall ( targetURL );
            successfulRetrieve = true;
        }
        catch ( MalformedURLException e ) {
            System.out.println ( "Problem encountered with the URL" );
        }
        catch ( IOException e ) {
            System.out.println ( "Problem encountered during communication" );
        }
        catch ( RuntimeException e ) {
            System.out.println ( "Location not found! Please try again." );
        }

    }

    public RESTClient ( String option, String location ) {
        location = removeSpaces ( location );
        OPTION_IS_WEATHER = option.equals ( "weather" );
        targetURL += option;
        targetURL += ( "?q=" + location );
        targetURL += "&appid=7a7c66caa87867e44442f9d2babdfc98";
        retrieveInfo ();
    }

    public RESTClient ( String option, double lat, double lon ) {
        OPTION_IS_WEATHER = option.equals ( "weather" );
        targetURL += option;
        targetURL += ( "?lat=" + lat + "&lon=" + lon );
        targetURL += "&appid=7a7c66caa87867e44442f9d2babdfc98";
        retrieveInfo ();
    }

    /**
     * Process the info from the website, building a human-readable String
     *
     * @return that String
     */
    public String processReadData () {

        if ( !successfulRetrieve )
            return "Could not retrieve data. Please, try again.";

        //variable definitions
        //<editor-fold>
        String dataFromJSON = "";

        JsonParserFactory jpf = Json.createParserFactory ( null );
        JsonParser parser = jpf.createParser ( new ByteArrayInputStream ( result.getBytes () ) );
        String cityName = "";
        String country = "";
        String coordinates = "";

        String key = "", value;
        int dayCounter = 0, windiestDay = 1, warmestDay = 1, coldestDay = 1;
        double highestTemp = Double.MIN_VALUE, lowestTemp = Double.MAX_VALUE;
        double highestWindSpeed = Double.MIN_VALUE;
        //</editor-fold>

        while ( parser.hasNext () ) {
            JsonParser.Event e = parser.next ();
            value = "";//clear value

            switch ( e ) {//<editor-fold>
                case KEY_NAME:
                    key = parser.getString ();
                    break;
                case VALUE_NUMBER:
                case VALUE_STRING:
                    value = parser.getString ();
                    break;
            }//</editor-fold>

            if ( !value.equals ( "" ) ) {//a value has been read, not a key name

                boolean dataHasBeenEntered = false;

                switch ( key ) {//<editor-fold>
                    case "lon":
                        coordinates += "Longitude:" + round ( parser.getBigDecimal ().doubleValue () ) + " ";
                        break;
                    case "lat":
                        coordinates += "Latitude:" + round ( parser.getBigDecimal ().doubleValue () );
                        break;
                    case "country":
                        country = value;
                        break;
                    case "name":
                        cityName = value;
                        break;
                    case "description":
                        //if forecast has been retrieved,
                        //than the ordering is different
                        if ( OPTION_IS_WEATHER ) {
                            dataFromJSON += "<br>";
                            if ( value.contains ( "cloud" ) )
                                status = StatusType.CLOUDS;
                            else if ( value.contains ( "rain" ) )
                                status = StatusType.RAIN;
                            else
                                status = StatusType.SUNNY;
                        }
                        else
                            status = StatusType.GRAPH;//the image should be set to a graph
                        dataFromJSON += "Status: " + value;
                        dataHasBeenEntered = true;
                        break;
                    case "temp":
                        dayCounter++;
                        if ( dayCounter > MAXIMUM_NUMBER_OF_DAYS )
                            break;
                        if ( !OPTION_IS_WEATHER )
                            dataFromJSON += "<br>Day " + dayCounter + "<br>";
                        double degrees = toCelsius ( parser.getBigDecimal () );
                        temps[dayCounter - 1] = degrees;
                        dataFromJSON += "Temperature: " + degrees + " degrees Celsius";

                        if ( degrees > highestTemp ) {
                            highestTemp = degrees;
                            warmestDay = dayCounter;
                        }
                        if ( degrees < lowestTemp ) {
                            lowestTemp = degrees;
                            coldestDay = dayCounter;
                        }
                        dataHasBeenEntered = true;
                        break;
                    case "3h":
                        dataFromJSON += "Rain: " + parser.getBigDecimal () + " inches in the last 3 hours";
                        dataHasBeenEntered = true;
                        break;
                    case "speed":
                        double windSpeed = round ( parser.getBigDecimal ().doubleValue () );
                        dataFromJSON += "Wind Speed: " + windSpeed + "m/s";
                        if ( windSpeed > highestWindSpeed ) {
                            highestWindSpeed = windSpeed;
                            windiestDay = dayCounter;
                        }
                        dataHasBeenEntered = true;
                        break;
                }//</editor-fold>

                if ( dayCounter > MAXIMUM_NUMBER_OF_DAYS )
                    break;

                if ( OPTION_IS_WEATHER )//do not need this for five day forecast
                    switch ( key ) {//<editor-fold>
                        case "pressure":
                            dataFromJSON += "Pressure: " + parser.getBigDecimal () + "hPa";
                            dataHasBeenEntered = true;
                            break;
                        case "humidity":
                            dataFromJSON += "Humidity: " + parser.getBigDecimal () + "%";
                            dataHasBeenEntered = true;
                            break;
                        case "deg":
                            dataFromJSON += "Wind direction: " + parser.getBigDecimal () + " degrees";
                            dataHasBeenEntered = true;
                            break;
                        case "all":
                            dataFromJSON += "Cloudiness: " + parser.getBigDecimal () + "%";
                            dataHasBeenEntered = true;
                            break;
                        case "temp_min":
                            dataFromJSON += "Minimum Temperature: " + toCelsius ( parser.getBigDecimal () ) + " degrees Celsius";
                            dataHasBeenEntered = true;
                            break;
                        case "temp_max":
                            dataFromJSON += "Maximum Temperature: " + toCelsius ( parser.getBigDecimal () ) + " degrees Celsius";
                            dataHasBeenEntered = true;
                            break;
                        case "sunrise":
                            dataFromJSON += "Sunrise: " + expressTime ( parser.getBigDecimal () );
                            dataHasBeenEntered = true;
                            break;
                        case "sunset":
                            dataFromJSON += "Sunset: " + expressTime ( parser.getBigDecimal () );
                            dataHasBeenEntered = true;
                            break;

                    }//</editor-fold>                

                if ( dataHasBeenEntered )
                    dataFromJSON += "<br>";

                if ( key.equals ( "cod" ) && value.equals ( "404" ) )//error code 404
                    return "Could not find location";

            }

        }

        if ( !OPTION_IS_WEATHER ) {//add statistics
            dataFromJSON += "<br>Highest temperature: " + highestTemp + " (day " + warmestDay + ")<br>";
            dataFromJSON += "Lowest temperature: " + lowestTemp + " (day " + coldestDay + ")<br>";
            dataFromJSON += "Most windy on day: " + windiestDay + ", wind speed: " + highestWindSpeed + "m/s<br>";
            scaledTemps = convertToScale ( temps );
        }
        dataFromJSON = coordinates + "<br>" + dataFromJSON;
        dataFromJSON = "Weather report for City: " + cityName + ", Country: " + country + "<br>" + dataFromJSON;
        dataFromJSON = "<html>" + dataFromJSON + "<html>";

        return dataFromJSON;

    }

    public int[] getScaledTemps () {
        return scaledTemps;
    }

    public StatusType getStatus () {
        return status;
    }

    private static int[] convertToScale ( double[] arr ) {
        int s = arr.length;
        int [] scaled = new int [s];

        double max = Double.MIN_VALUE, min = Double.MAX_VALUE;
        for ( int i = 0; i < s; i++ ) {

            if ( max < arr[i] )
                max = arr[i];

            if ( min > arr[i] )
                min = arr[i];

        }

        double totalDistance = max - min;

        for ( int i = 0; i < s; i++ ) {
            double dist = (arr[i] - min);
            dist *= 500.0;
            dist /= totalDistance;
            scaled[i] = (int) dist;
        }
        
        return scaled;
    }

    //rounds to the second digit after the floating point
    private static double round ( double value ) {

        value *= 1000;
        int v = (int) value;
        if ( v % 10 > 4 )
            v += 10;
        v /= 10;
        value = v / 100.0;

        return value;
    }

    private static double toCelsius ( BigDecimal kelvin ) {

        double celsius = kelvin.doubleValue () - 273.15;
        return round ( celsius );

    }

    private static String expressTime ( BigDecimal sec ) {
        long time = (long) sec.doubleValue ();
        Date d = new Date ( time * 1000L );

        String timeZone = d.toString ().substring ( 20, 24 );

        int hours = d.getHours (), minutes = d.getMinutes (), seconds = d.getSeconds ();
        String hh = "", mm = "", ss = "";

        if ( hours < 10 )
            hh += "0";
        hh += hours;

        if ( minutes < 10 )
            mm += "0";
        mm += minutes;

        if ( seconds < 10 )
            ss += "0";
        ss += seconds;

        return hh + ":" + mm + ":" + ss + " " + timeZone;
    }

    /**
     * Takes a String and removes all spaces
     *
     * @param word - word to process
     * @return - same word, after having been processed
     */
    private static String removeSpaces ( String word ) {
        StringBuilder sb = new StringBuilder ( word );
        int l = word.length ();

        for ( int i = 0; i < l; i++ ) {
            
            if ( sb.charAt ( i ) == ' ' ) {
                sb.deleteCharAt ( i );
                i--;
                l--;
            }
        }

        return sb.toString ();
    }

}
