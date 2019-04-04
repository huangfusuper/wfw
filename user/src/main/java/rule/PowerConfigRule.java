package rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 皇甫
 */
@Configuration
public class PowerConfigRule {

    @Bean
    public IRule iRule(){
        return new RoundRobinRule();
    }
}
