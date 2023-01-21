package io.github.arrudalabs.it;


import com.soebes.itf.jupiter.extension.MavenJupiterExtension;
import com.soebes.itf.jupiter.extension.MavenTest;
import com.soebes.itf.jupiter.maven.MavenExecutionResult;

import static com.soebes.itf.extension.assertj.MavenITAssertions.assertThat;

@MavenJupiterExtension
public class GreetingMojoIT {

    @MavenTest
    void the_first_test_case(MavenExecutionResult result) {
        assertThat(result).isSuccessful()
                .out()
                .info().contains("Hello, world!");
    }

}

