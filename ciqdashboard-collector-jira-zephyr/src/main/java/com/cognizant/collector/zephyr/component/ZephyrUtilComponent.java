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

package com.cognizant.collector.zephyr.component;


import com.cognizant.collector.jira.client.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.net.*;
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

import static com.cognizant.collector.zephyr.constants.Constant.*;

/**
 * CommonUtilComponent
 * @author Cognizant
 */

@Component
@Slf4j
public class ZephyrUtilComponent {


    @Autowired
    JiraClient jiraClient;
    @Value("${zephyrServer.url}")
    private String zephyrServerUrl;
    @Value("${zephyrServer.accessKey}")
    private String zephyrAccessKey;
    @Value("${zephyrServer.secretKey}")
    private String zephyrSecretKey;

    public String getAccountID() {
        return (String) ((Map) jiraClient.getAcccountID()).get("accountId");
    }

    public String getJWT(String endpoint) {

//        Jwt jwt = new Jwt();

//        ZephyrJwt zephyrJwt = new ZephyrJwt();
//
//        String jwt = zephyrJwt
//                            .getClient(zephyrServerUrl+endpoint, zephyrAccessKey, zephyrSecretKey, getAccountID())
//                            .generateJwt("GET", URI.create(zephyrServerUrl), EXPIRATION_IN_SECONDS);

        return null;
    }

    static String collectionName;

    @Value("${spring.data.mongodb.collection.zephyr.execution}")
    public void setCollectionName(String collectionName) {
        this.collectionName = SOURCE+collectionName;
    }

    public static String getCollectionName(){
        return collectionName;
    }
}
