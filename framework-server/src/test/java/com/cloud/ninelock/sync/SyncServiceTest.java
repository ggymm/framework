package com.cloud.ninelock.sync;

import com.cloud.Application;
import com.cloud.ninelock.api.service.SyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author gongym
 * @version 创建时间: 2021-11-05 18:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SyncServiceTest {

    @Resource
    private SyncService syncService;

    @Test
    public void TestSyncDept() {
        syncService.syncDept();
    }
}
