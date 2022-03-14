package automation.utils;

import io.cucumber.java.it.Ma;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Constant_Storage {
    /*
    > we are using constant class to store the data we are sending from UI and to compare the data with the DataBase
    > at work, we use HashMap, But for Study purpose i am using Linked Hash Map----> Hashmap has no order so adding, removing, finding is faster and  memory efficient
     */


    public static Map<String, String> inputDataOnUI = new LinkedHashMap<>();
    public static Map<String, String> dataFromDataBase = new LinkedHashMap<>();






}
