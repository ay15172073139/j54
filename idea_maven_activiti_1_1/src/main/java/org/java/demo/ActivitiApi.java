package org.java.demo;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivitiApi {

    private ProcessEngine engine= ProcessEngines.getDefaultProcessEngine();

    @Test
    public  void deploymentDefinition(){

        RepositoryService repositoryService=engine.getRepositoryService();

        InputStream bpmn_in=this.getClass().getClassLoader().getResourceAsStream("diagrams/purchar.bpmn");
        InputStream png_in=this.getClass().getClassLoader().getResourceAsStream("diagrams/purchar.png");

        String bpmn="purchar.bpmn";
        String png="purchar.png";

        Deployment deploy = repositoryService.createDeployment().addInputStream(bpmn, bpmn_in).addInputStream(png, png_in).deploy();

        System.out.println("部署成功");
        System.out.println("部署id:"+deploy.getId());

    }


    @Test
    public void startInstance(){
        RuntimeService runtimeService=engine.getRuntimeService();
        String ProcessDefinitionKey="myProcess_1";
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("price", 900);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(ProcessDefinitionKey, map);
        System.out.println("实例已启动，启动的流程实例id是:"+processInstance.getProcessInstanceId());
    }

    /**
     * 查询个人的任务
     */
    @Test
    public void QueryPersonTask() {
        TaskService taskService = engine.getTaskService();
        TaskQuery query = taskService.createTaskQuery();
        String assignee = "xufen";
        query.taskAssignee(assignee);
        List<Task> tasks = query.list();
        for (Task t  : tasks) {
            System.out.println("任务id" + t.getId());
            System.out.println("任务名称:" + t.getName());
            System.out.println("任务办理人:" + t.getAssignee());
            System.out.println("任务创建时间:" + t.getCreateTime());
            System.out.println("流程定义id" + t.getProcessDefinitionId());
            System.out.println("---------------------------");
        }
    }

    @Test
    public void CompleteTask() {
        TaskService taskService = engine.getTaskService();
        String taskId = "205";
        taskService.complete(taskId);
        System.out.println("任务完成");
    }

}
