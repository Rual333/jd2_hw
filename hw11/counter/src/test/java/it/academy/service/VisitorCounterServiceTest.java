package it.academy.service;

import it.academy.data.DaoConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@ContextConfiguration(classes = DaoConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class VisitorCounterServiceTest {

    public static final Logger log = Logger.getLogger(VisitorCounterServiceTest.class.getName());

    @Autowired
    WebApplicationContext context;

    @Autowired
    VisitorCounterService visitorCounterService;

    MockMvc mockMvc;
    int numberOfThreads = 1000;
    CountDownLatch countDownLatch;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        visitorCounterService.setCount(1, 0);
        countDownLatch = new CountDownLatch(numberOfThreads);
    }


    @Test
    public void updateVisitorCount() throws Exception {
        final ExecutorService executorService =
                Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(() -> {
            try {
                mockMvc
                        .perform(put("/visitor_count")).andReturn();
                countDownLatch.countDown();
            } catch (Exception e) {
                e.printStackTrace();

            }
            });
        }
        countDownLatch.await();

        final MvcResult mvcResult = mockMvc
                .perform(get("/visitor_count")).andReturn();
        final String content = mvcResult.getResponse().getContentAsString();
        log.info(content);
        assertEquals("1000", content);
    }

}