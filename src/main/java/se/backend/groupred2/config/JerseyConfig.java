package se.backend.groupred2.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
      /*  register(IssueResource.class);
        register(TaskResource.class);
        register(TeamResource.class);
        register(UserResource.class);
        register(InvalidInputMapper.class);
        register(InvalidTaskMapper.class);
        register(InvalidUserMapper.class);
        register(InvalidTeamMapper.class);*/

        packages("se.backend.groupred2.resource");
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().registerModule(new ParameterNamesModule());
    }
}
