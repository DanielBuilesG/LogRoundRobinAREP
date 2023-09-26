package org.example;

import static spark.Spark.*;


public class Main {
    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");
        get("/log", (req, res) -> {
            String val = req.queryParams("value");
            return logMessage(val);
        });
    }

    private static int getPort(){
        if(System.getenv("PORT") != null ){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String logMessage(String val){
        return """
               {
               "m1":"mensaj1",
               "m2":"mensaj2",
               "m3":"mensaj3"
               }
               """;
    }
}