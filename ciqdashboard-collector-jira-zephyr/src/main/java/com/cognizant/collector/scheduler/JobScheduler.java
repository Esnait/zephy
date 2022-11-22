/*
 *  © [2021] Cognizant. All rights reserved.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.cognizant.collector.scheduler;

import lombok.extern.slf4j.*;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;

import javax.annotation.*;
/**
 * JobScheduler
 * @author Cognizant
 */

@Component
@Slf4j
public class JobScheduler {
    @Autowired
    private ApplicationContext appContext;

    @Value("${scheduler.enable}")
    private boolean isSchedulerEnabled;
    private String type = "Collector";

    BatchEvents batchEvents = null;
    String[] beanNamesForType = null;

    @Scheduled(cron = "${scheduler.cron}")
    public void cronScheduler() {
        validCheckToProcess();
        log.info("*******************************************cron <Start>********************************************************************");
        batchEvents.beforeJob();
        log.info("********************************************cron <End>*******************************************************************");
    }

    private void validCheckToProcess() {
        if (!isSchedulerEnabled)  throw new RuntimeException();
    }

    @PostConstruct
    private void postConstructor() {
        try {
            batchEvents = (BatchEvents) appContext.getBean(BatchEvents.class);
        } catch (NoSuchBeanDefinitionException e) {
            log.info("Collector processed successfully, but scheduler terminating due to below reasons");
            log.error("No Such beans found: {}", e.getLocalizedMessage());
            log.info("Beans are not found so we are stopping the scheduler, Please implement beans and rerun if you want to run in scheduler manner");
        }
    }
}
