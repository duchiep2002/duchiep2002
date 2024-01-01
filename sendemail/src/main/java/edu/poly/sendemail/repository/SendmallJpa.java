package edu.poly.sendemail.repository;

import edu.poly.sendemail.entity.Person;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendmallJpa {
    @Autowired
    private IdpersonDao idpersonDao;

    @Autowired
    private JavaMailSender javaMailSender;

    public Person save(Person person){
       return idpersonDao.save(person);
    }

    public Person update(Person person){
        return idpersonDao.save(person);
    }

    public void delete(Long id){
        idpersonDao.deleteById(id);
    }
    public Person find(Long id) {
        return idpersonDao.findById(id).orElse(null);
    }

    public List<Person> findAll() {
        return idpersonDao.findAll();
    }

    public void sendEmail(Person person, String subject, String text) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(person.getEmail());
        helper.setSubject(subject);
        helper.setText(text);
        javaMailSender.send(message);
    }

}
