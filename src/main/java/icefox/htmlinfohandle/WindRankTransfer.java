package icefox.htmlinfohandle;

public class WindRankTransfer {
	public double transfer(String input) {

		input = input.replace("级", "");
		double result = 0;
		if (input.contains("转")) {
			String[] arrays = input.split("转");

			for (String array : arrays) {
				if (array.contains("-")) {
					double part1 = 0;
					for (String value : array.split("-")) {
						part1 += 0.5 * rankStandard(value);
					}
					result += 0.5 * part1;

				} else {
					double part1 = rankStandard(array);
					result += 0.5 * part1;
				}
			}
		} else {
			if (input.contains("-")) {
				double part1 = 0;
				for (String value : input.split("-")) {
					part1 += 0.5 * rankStandard(value);
				}
				result +=  part1;

			} else {
				double part1 = rankStandard(input);
				result +=  part1;
			}
		}
		return result;

	}

	public double rankStandard(String value) {
		switch (value) {
		case "小于3":
			return 2.0;
		case "微风":
			return 2.0;
		case "3":
			return 4.4;
		case "4":
			return (5.5 + 7.9) / 2.0;
		case "5":
			return (8.0 + 10.7) / 2.0;
		case "6":
			return (10.8 + 13.8) / 2.0;
		case "7":
			return (13.9 + 17.1) / 2.0;
		case "8":
			return (17.2 + 20.7) / 2.0;
		case "9":
			return (20.8 + 24.4) / 2.0;
		case "10":
			return (24.5 + 28.4) / 2.0;
		case "11":
			return (28.5 + 32.6) / 2.0;
		case "12":
			return (32.7 + 36.9) / 2.0;
		}
		return 0;

	}

}
