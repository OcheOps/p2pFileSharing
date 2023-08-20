public class Request {

    public static String sendPostRequest(String body, String host){
        try{
            URL url = new URL(host);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
            wr.write(body);
            wr.flush();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String ln;
            StringBuffer response = new StringBuffer();
            while((ln = in.readLine())!= null){
                response.append(ln);
            }
            in.close();
            return response.toString();

        }catch(Exception e){
            System.out.println(e);
            return null;
        }
