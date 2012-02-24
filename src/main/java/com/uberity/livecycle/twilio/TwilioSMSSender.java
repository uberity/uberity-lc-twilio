package com.uberity.livecycle.twilio;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c) 2012 Uberity Technology Corporation.  All Rights Reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy 
 * of this software and associated documentation files (the "Software"), to deal 
 * in the Software without restriction, including without limitation the rights 
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies 
 * of the Software, and to permit persons to whom the Software is furnished to do so, 
 * subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all 
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

public class TwilioSMSSender {

    /**
     * Sends an SMS message using the twilio Java client.  Go to Twilio.com to sign up
     * and get your SID and AUTH.
     *
     * @param sid Twilio SID
     * @param auth Twilio AUTH
     * @param from The from phone number, as configured at Twilio.com
     * @param to The recipient's phone number, as configured at Twilio.com
     * @param message SMS message
     * @return Boolean.TRUE is all is OK, or Boolean.FALSE if there was an exception.
     */
    public Boolean sendSMS(String sid, String auth, String from, String to, String message) {
        TwilioRestClient client = new TwilioRestClient( sid, auth );
        Account account = client.getAccount();
        SmsFactory smsFactory = account.getSmsFactory();
        Map<String,String> smsParams = new HashMap<String,String>();
        smsParams.put("To", to);
        smsParams.put("From", from);
        smsParams.put("Body", message);
        try {
            smsFactory.create(smsParams);
        } catch ( TwilioRestException e ) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}