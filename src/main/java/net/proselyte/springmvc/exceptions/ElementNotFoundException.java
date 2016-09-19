package net.proselyte.springmvc.exceptions;

/**
 * Created by Администратор on 13.09.16.
 */

@SuppressWarnings("serial")
public class ElementNotFoundException extends Exception {


        public ElementNotFoundException() {
        }

        public ElementNotFoundException(String message) {
            super(message);
        }

}
