package tests;
import com.codeborne.selenide.Configuration;
import commonsteps.OpenPage;
import commonsteps.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestPracticeForm extends RegistrationPage{


    String site = "https://demoqa.com/automation-practice-form/",
            firstName = "Julia",
            lastName = "Shu",
            email = "jull@mail.ru",
            gender = "Male",
            mobile = "8903930999",
            monthOfBirth = "April",
            yearOfBirth = "2004",
            dayOfBirth = "14",
            subject1 = "Maths",
            hobby1 = "Sports",
            hobby2 = "Reading",
            hobby3 = "Music",
            picture = "1.png",
            currentAddress = "Siberia",
            state = "NCR",
            city = "Delhi";

    RegistrationPage registrationPage = new RegistrationPage();
    OpenPage openPage = new OpenPage();

    @BeforeAll
    static void setStartConfig() {
        Configuration.startMaximized = true;
    }

    @Test
    void testRequiredFields() {

        openPage.open(site);

        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeUserEmail(email);
        registrationPage.setGender();
        registrationPage.typeUserNumber(mobile);
        registrationPage.setSubmit();

        //form contains text
        registrationPage.checkTable(firstName+" "+ lastName,
                email,
                gender,
                mobile);

    }

    @Test
    void testFullFields() {

        openPage.open(site);

        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeUserEmail(email);
        registrationPage.setGender();
        registrationPage.typeUserNumber(mobile);

        registrationPage.dateOfBirthInput(dayOfBirth, monthOfBirth, yearOfBirth);
        registrationPage.setSubjectsInput(subject1);
        registrationPage.setCheckbox1(hobby1);
        registrationPage.setCheckbox2(hobby2);
        registrationPage.setCheckbox3(hobby3);
        registrationPage.uploadFrom(picture);
        registrationPage.typeAddress(currentAddress);
        registrationPage.setCountry(state) ;
        registrationPage.setCity(city);
        registrationPage.setSubmit();

        //form contains text
        registrationPage.checkFullTable(firstName+" "+ lastName,
                email,
                gender,
                mobile,
                dayOfBirth + " " + monthOfBirth + "," + yearOfBirth,
                subject1,
                hobby1 + ", " + hobby2 + ", " + hobby3,
                picture,
                currentAddress,
                state + " " + city);

    }

}

//доп методы
//$(byName("q")).setValue("Selenide").pressEnter();
//$("").parent().click()
//Configuration.timeout = 600000;
//Selenide.sleep(5000);
