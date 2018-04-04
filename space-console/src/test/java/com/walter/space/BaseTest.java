package com.walter.space;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author walterwu
 * @date 2018/04/04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BaseTest {
  protected final static Logger LOG = LoggerFactory.getLogger(BaseTest.class);
}
