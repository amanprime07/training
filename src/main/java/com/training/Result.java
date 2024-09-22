package com.training;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Result {

        /*
         * Complete the 'evaluate' function below.
         *
         * The function is expected to return output as STRING_ARRAY.
         * The function accepts STRING api as parameter.
         */

        private static class Response{
            private String groupName;
            private List<Expression> expressions;
            public String getGroupName() {
                return groupName;
            }

            public List<Expression> getExpressions() {
                return expressions;
            }
        }

        private static class Expression {
            private String name;
            private String expressionType;
            private String expression;
            private List<String> dependencies;

            public String getName() {
                return name;
            }

            public String getExpressionType() {
                return expressionType;
            }

            public String getExpression() {
                return expression;
            }
            public List<String> getDependencies(){
                return dependencies;
            }
        }

        public static List<String> evaluate(String api) {
            try{
                // System.out.println(api);
                // Write your code here
                URL url = new URL(api);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                int responseCode = connection.getResponseCode();
                // System.out.println(responseCode);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer responseBuffer = new StringBuffer();
                String inputLine;
                while((inputLine = bufferedReader.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                // System.out.println(responseBuffer.toString());
                Type listType = new TypeToken<ArrayList<Response>>(){}.getType();
                List<Response> response = new Gson().fromJson(responseBuffer.toString(), listType);
                // List<Response> response = new ArrayList<>();
                if(response!= null && !response.isEmpty()){
                    return parseResponse(response);
                }
            } catch(Exception ignore) {
                // ignoring exception for now
            }
            return Collections.emptyList();
        }

        private static List<String> parseResponse(List<Response> responseList) {
            List<String> finalExpression = new ArrayList<>();
            for(Response response: responseList){
                String value = createExpressionMap(response.getGroupName(), response.getExpressions());
                System.out.println(value);
            }
            return finalExpression;
        }

        private static String createExpressionMap(String groupName, List<Expression> expressions){
            Map<String, String> map = new HashMap<>();
            StringBuilder builder = new StringBuilder(groupName);
            for(Expression ex: expressions){
                String value =
                        resolveExpression(ex.getName(), ex.getExpressionType(), ex.getExpression(), ex.getDependencies(), map);
                map.put(ex.getName(), value);
                builder.append(":").append(ex.getName()).append(":").append(value);
            }
            return builder.toString();
        }

        private static String resolveExpression(String name, String expressionType, String expression, List<String> dependencies, Map<String, String> expressionMap){
            switch(expressionType) {
                case "DIRECT":
                    expressionMap.put(name, expression);
                    return expression;
                case "DOLLAR_EXPRESSION":
                    String dollarTemp = expression;
                    for(String entry: dependencies){
                        if(expressionMap.containsKey(entry)){
                            String key = "${"+entry + "}";
//                            System.out.println(key);
                            dollarTemp = dollarTemp.replace(key, expressionMap.get(entry));
                        }
                    }
                    dollarTemp = "(" + dollarTemp + ") $";
                    expressionMap.put(name, dollarTemp);
                    return dollarTemp;
                case "RS_EXPRESSION":
                    String rsTemp = expression;
                    for(String entry: dependencies){
                        rsTemp = rsTemp.replace("${"+entry + "}", expressionMap.get(entry));
                    }
                    rsTemp = "(" + rsTemp + ") RS";
                    expressionMap.put(name, rsTemp);
                    return rsTemp;
            }
            return "";
        }

    public static void main(String[] args) {
//        Result.evaluate("https://raw.githubusercontent.com/arcjsonapi/expressionDataService/main/expressions");
                int i = 0;
                loop: for (; true; i++) {
                    System.out.println(">>" + i);
                    for (; i < 5; i++) {
                        System.out.println(">"+i);
                        if (i == 3) break loop;
                    }
                }
                System.out.println(i);
            }

}
