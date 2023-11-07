package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


import static lotto.validator.InputValidator.*;
import static lotto.validator.MoneyValidator.validatePurchaseAmount;
import static lotto.validator.TokenizedInputValidator.*;

public class InputView {

    public static final String USER_MONEY_INPUT_MSG = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_INPUT_MSG = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT_MSG = "보너스 번호를 입력해 주세요.";
    public static final String SEPARATOR = ",";

    public static long getLottoPayment() {
        printMessage(USER_MONEY_INPUT_MSG);

        String money = Console.readLine();
        validateLottoPurchaseAmount(money);
        validatePurchaseAmount(Long.parseLong(money));
        return Long.parseLong(money);
    }

    public static List<Integer> getWinningNumber() {
        printMessage(WINNING_NUMBER_INPUT_MSG);

        String winningNumber = Console.readLine();
        return convertStringToIntegerList(winningNumber);
    }

    public static int getBonusNumber() {
        printMessage(BONUS_NUMBER_INPUT_MSG);

        String bonusNumber = Console.readLine();
        checkBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    public static List<Integer> convertStringToIntegerList(String winningNumber) {
        check(winningNumber.split(SEPARATOR));

        String[] numberStrings = winningNumber.split(SEPARATOR);
        List<Integer> numberList = new ArrayList<>();

        for (String numberStr : numberStrings) {
            numberList.add(Integer.parseInt(numberStr.trim()));
        }

        return numberList;
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
