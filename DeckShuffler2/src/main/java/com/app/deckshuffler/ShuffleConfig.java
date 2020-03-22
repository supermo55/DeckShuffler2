package com.app.deckshuffler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/** config to decide if simpleShuffle should or complexShuffle **/
@Configuration
public class ShuffleConfig {
    @Bean
    @Profile("!complex")
    public Shuffler defaultShuffler()
    {
        return new SimpleShuffle();
    }
    @Bean
    @Profile("complex")
    public Shuffler complexShuffler()
    {
        return new ComplexShuffle();

    }

}
