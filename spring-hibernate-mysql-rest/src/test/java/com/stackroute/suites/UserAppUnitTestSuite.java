package com.stackroute.suites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import com.stackroute.repository.UserRespositoryTest;

@RunWith(JUnitPlatform.class)
@SelectClasses(value = {UserRespositoryTest.class})
public class UserAppUnitTestSuite {

}
