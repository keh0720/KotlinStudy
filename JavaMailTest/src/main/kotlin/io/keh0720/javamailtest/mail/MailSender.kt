package io.keh0720.javamailtest.mail

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl

@Configuration
class MailSender {
    @Value("\${spring.mail.host}")
    private val host: String? = null

    @Value("\${spring.mail.port}")
    private val port: Int = 0

    @Value("\${spring.mail.username}")
    private val username: String? = null

    @Value("\${spring.mail.password}")
    private val password: String? = null

    @Bean
    fun getJavaMailSender(): JavaMailSender {
        val javaMailSender = JavaMailSenderImpl()
        javaMailSender.host = host
        javaMailSender.port = port
        javaMailSender.username = username
        javaMailSender.password = password

        val props = javaMailSender.javaMailProperties
        props["mail.transport.protocol"] = "smtp"
        props["mail.smtp.auth"] = "true";
        props["mail.smtp.starttls.enable"] = "true";
        props["mail.debug"] = "true";

        return javaMailSender
    }
}