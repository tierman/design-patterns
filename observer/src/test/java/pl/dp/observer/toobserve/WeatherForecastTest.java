package pl.dp.observer.toobserve;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.dp.observer.notification.Email;
import pl.dp.observer.notification.Sms;

import static org.mockito.Mockito.*;

class WeatherForecastTest {

    private Email emailNotification;
    private Sms smsNotification;

    @BeforeEach
    void setUp() {
        emailNotification = mock(Email.class);
        smsNotification = mock(Sms.class);
    }

    @Test
    void updateForecast_sendEmailAndSMS_correctly() {
        //given
        WeatherForecast weatherForecast = new WeatherForecast();
        weatherForecast.registerObserver(emailNotification);
        weatherForecast.registerObserver(smsNotification);

        //when
        weatherForecast.updateForecast(22.3f, 1014);
        //then
        verify(emailNotification, times(1)).notify(anyFloat(), anyInt());
        verify(smsNotification, times(1)).notify(anyFloat(), anyInt());
    }

    @Test
    void updateForecast_sendEmailWithoutSMS_correctly() {
        //given
        WeatherForecast weatherForecast = new WeatherForecast();
        weatherForecast.registerObserver(emailNotification);
        weatherForecast.registerObserver(smsNotification);
        weatherForecast.unregisterObserver(smsNotification);

        //when
        weatherForecast.updateForecast(22.3f, 1014);

        //then
        verify(emailNotification, times(1)).notify(anyFloat(), anyInt());
        verify(smsNotification, times(0)).notify(anyFloat(), anyInt());
    }
}