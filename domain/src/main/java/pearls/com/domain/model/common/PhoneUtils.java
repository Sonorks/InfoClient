package pearls.com.domain.model.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PhoneUtils {

    public static boolean validateCellPhoneNumber(String phoneNumber){
        return phoneNumber != null && !phoneNumber.isEmpty() && phoneNumber.matches("^[0-9]{12}");
    }
}
