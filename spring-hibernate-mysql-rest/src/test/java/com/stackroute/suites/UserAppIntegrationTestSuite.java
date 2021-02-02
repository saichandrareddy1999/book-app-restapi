package com.stackroute.suites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import com.stackroute.controller.UserControllerTest;

import com.stackroute.repository.UserRespositoryTest;

import com.stackroute.service.UserServiceIntegrationTest;

@RunWith(JUnitPlatform.class)
@SelectClasses(value = {UserServiceIntegrationTest.class,UserRespositoryTest.class,UserControllerTest.class})
public class UserAppIntegrationTestSuite {

}
