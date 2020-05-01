package interview;


import java.io.IOException;

public class PoolOfHttpConnections {
    static String[] urisToGet = {"http://www.site1.com", "http://www.site2.com"};

    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // create a thread for each link
        GetThread[] threads = new GetThread[urisToGet.length];
        for (int i = 0; i < threads.length; i++) {
            HttpGet httpget = new HttpGet(urisToGet[i]);
            threads[i] = new GetThread(httpClient, httpget);
        }

        // start the threads
        for (int j = 0; j < threads.length; j++) {
            threads[j].start();
        }
        // join the threads
        for (int j = 0; j < threads.length; j++) {
            threads[j].join();
        }
    } //end main

    private static class GetThread extends Thread {

        private final CloseableHttpClient httpClient;
        private final HttpContext context;
        private final HttpGet httpget;

        public GetThread(CloseableHttpClient httpClient, HttpGet httpget) {
            this.httpClient = httpClient;
            this.context = HttpClientContext.create();
            this.httpget = httpget;
        }

        @Override
        public void run() {
            try {
                CloseableHttpResponse response = httpClient.execute(httpget, context);
                try {
                    HttpEntity entity = response.getEntity();
                    System.out.println("----------------------------------------");
                    Date date = new Date();
                    System.out.println("Beginning*******************");
                    System.out.println(date.toString());
                    System.out.println("There are " + urisToGet.length + " threads running in parallel!");
                    System.out.println(response.getStatusLine());
                    if (entity != null) {
                        System.out.println("Response content length: " + entity.getContentLength());
                    }
                    System.out.println(EntityUtils.toString(entity));
                    EntityUtils.consume(entity);
                } finally {
                    response.close();
                    System.out.println("End*******************");
                }
            } catch (ClientProtocolException ex) {
                // Handle protocol errors
            } catch (IOException ex) {
                // Handle I/O errors
            }
        }
    }
}
