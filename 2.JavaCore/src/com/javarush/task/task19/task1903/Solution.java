package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");

    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;
        private String company = "JavaRush Ltd.";

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }


        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            String aimName = " ";
            for (Map.Entry<String, String> map :countries.entrySet()) {
                if (data.getCountryCode().equals(map.getKey())){
                    aimName = map.getValue();
                }
            }
            return aimName;
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String pn =String.format("%010d", data.getPhoneNumber());
            StringBuilder sbTotal = new StringBuilder();
            sbTotal.append("+").append(data.getCountryPhoneCode()).append("(");
            sbTotal.append(pn.charAt(0)).append(pn.charAt(1)).append(pn.charAt(2)).append(")");
            sbTotal.append(pn.charAt(3)).append(pn.charAt(4)).append(pn.charAt(5)).append("-");
            sbTotal.append(pn.charAt(6)).append(pn.charAt(7)).append("-");
            sbTotal.append(pn.charAt(8)).append(pn.charAt(9));

            return sbTotal.toString();
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}