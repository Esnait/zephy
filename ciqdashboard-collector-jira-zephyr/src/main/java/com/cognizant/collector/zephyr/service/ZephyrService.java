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

package com.cognizant.collector.zephyr.service;

import com.cognizant.collector.zephyr.beans.*;
import com.cognizant.collector.zephyr.repo.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * ZephyrService
 * @author Cognizant
 */

@Service
public class ZephyrService {

    @Autowired
    ZephyrRepository zephyrRepository;

    public List<ExecutionDetails> saveAll(List<ExecutionDetails> executionDetailsList) {
        return zephyrRepository.saveAll(executionDetailsList);
    }

    public ExecutionDetails save(ExecutionDetails executionDetails) {
        return zephyrRepository.save(executionDetails);
    }
}
