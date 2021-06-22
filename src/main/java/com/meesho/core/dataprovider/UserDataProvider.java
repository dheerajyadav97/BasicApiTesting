package com.meesho.core.dataprovider;

import org.testng.annotations.DataProvider;

public class UserDataProvider {

    //data provider identifier
    @DataProvider(name = "userPostData")

    //return array of object
    public Object[][] userPostData() {
        return new Object[][]{
                {"Bob", "Automation Testing"},
                {"Anne", "Software engineer"},
                {"Dheeraj", "Software tester"},
                {"Bhanu", "Software Test Engineer"},
        };
    }


}
