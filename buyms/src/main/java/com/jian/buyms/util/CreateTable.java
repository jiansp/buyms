package com.jian.buyms.util;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;

/**
 * @author xx1
 * Created by xx1 on 2018/4/25.
 */
public class CreateTable {
    @Test
    public void createTable(){
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
        System.out.println("-------processEngine:"+processEngine);
    }

    @Test
    public void deployFlow(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        Deployment deployment = processEngine.getRepositoryService().createDeployment()
                .addClasspathResource("bmpn/HelloWord.bpmn").addClasspathResource("bmpn/HelloWord.png").deploy();

    }

}
