package com.recaptcha.interfaces;

import java.io.IOException;
import java.net.MalformedURLException;

public interface IRecaptchaManager {

    String verify(final String token) throws IOException, InterruptedException;
}
