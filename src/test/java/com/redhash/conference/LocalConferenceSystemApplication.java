package com.redhash.conference;

import org.springframework.boot.builder.SpringApplicationBuilder;

class LocalConferenceSystemApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConferenceSystemApplication.class)
                .initializers(new StandaloneApplicationContextInitializer())
                .profiles("dev")
                .run(args);
    }

}
