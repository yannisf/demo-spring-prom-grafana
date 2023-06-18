package eu.frlab.metrics

import io.micrometer.core.aop.CountedAspect
import io.micrometer.core.aop.TimedAspect
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class MetricsApplication {

    @Bean
    fun timedAspect(registry: MeterRegistry) = TimedAspect(registry)

    @Bean
    fun countedAspect(registry: MeterRegistry) = CountedAspect(registry)

}

fun main(args: Array<String>) {
    runApplication<MetricsApplication>(*args)
}
