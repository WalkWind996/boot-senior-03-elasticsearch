package com.walkwind.boot;

import com.walkwind.boot.bean.Employee;
import com.walkwind.boot.repository.EmployeeRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.io.IOException;
import java.util.Optional;

@SpringBootTest
class BootSenior03ElasticsearchApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;
    @Test
    void repositoryTest(){
        /*向索引中添加文档*/
        Employee employee = new Employee(2, "李四", "SS", "海王");
        employeeRepository.save(employee);
        /*检索文档
        Optional<Employee> byId = employeeRepository.findById(1);
        System.out.println(byId.get().toString());*/
    }

    @Test
    void contextLoads() throws IOException {
        //给es中索引一个文档   /company/person/1
        Index index = new Index.Builder(new Employee(1, "张三", "CC", "老实人")).index("company").type("person").build();
        jestClient.execute(index);
    }

    @Test
    void contextLoads1() throws IOException {
        //从es中检索描述字段为老实人的文档   get/company/person/1
        String queryJson = "{\n" +
                "    \"query\" : {\n" +
                "        \"match_phrase\" : {\n" +
                "            \"description\" : \"老实人\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search search = new Search.Builder(queryJson).addIndex("company").addType("person").build();
        SearchResult result = jestClient.execute(search);
        System.out.println(result.getJsonString());
    }
}
