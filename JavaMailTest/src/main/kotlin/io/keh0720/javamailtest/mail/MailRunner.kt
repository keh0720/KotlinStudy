package io.keh0720.javamailtest.mail

import org.springframework.boot.CommandLineRunner
import org.springframework.core.io.FileSystemResource
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Component
import java.io.File

@Component
class MailRunner(
    private val mailSender: JavaMailSender
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        // Simple mail
//        val message = SimpleMailMessage()
//        message.setFrom("appres0001@gmail.com")
//        message.setTo("keh0720@gmail.com")
//        message.setSubject("Mail send test")
//        message.setText("mail test")
//
//        mailSender.send(message)

        // File attachment
//        val mimeMessage = mailSender.createMimeMessage()
//        val mimeMessageHelper = MimeMessageHelper(mimeMessage, true)
//        mimeMessageHelper.setFrom("appres0001@gmail.com")
//        mimeMessageHelper.setTo("keh0720@gmail.com")
//        mimeMessageHelper.setSubject("Mail send test")
//        mimeMessageHelper.setText("mail test")
//
//        val attachedFile = FileSystemResource(File(javaClass.classLoader.getResource("./templates/mail_template.html").file))
//        mimeMessageHelper.addAttachment("mail_template.html", attachedFile)
//
//        mailSender.send(mimeMessage)

        // via template
        val mimeMessage = mailSender.createMimeMessage()
        val mimeMessageHelper = MimeMessageHelper(mimeMessage, true)
        mimeMessageHelper.setFrom("appres0001@gmail.com")
        mimeMessageHelper.setTo("keh0720@gmail.com")
        mimeMessageHelper.setSubject("Mail send test")

        val templateFile =
            FileSystemResource(File(javaClass.classLoader.getResource("./templates/mail_template.html").file))

        println(templateFile.file.readText())

        val contents = templateFile.file.readText()

        mimeMessageHelper.setText(contents, true)

        mailSender.send(mimeMessage)

    }
}