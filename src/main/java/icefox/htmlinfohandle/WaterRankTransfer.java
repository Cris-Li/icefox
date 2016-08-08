package icefox.htmlinfohandle;

public class WaterRankTransfer {
	public double transfer(String input) {
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
		case "小雨":
			return 2.5;
		case "阵雨":
			return 2.5;
		case "中雨":
			return 10.0;
		case "大雨":
			return 22.5;
		case "雷阵雨":
			return 16.5;
		case "暴雨":
			return 50.0;
		case "大暴雨":
			return 77.5;
		case "特大暴雨":
			return 175.0;
		case "小雪":
			return 0.5;
		case "雨夹雪":
			return 0.5;
		case "中雪":
			return 2.0;
		case "大雪":
			return 4.5;
		case "暴雪":
			return 8.0;
		}
		return 0;

	}

}
