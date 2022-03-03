package com.example.enums;

/**
 * 盐城区域信息
 */
public enum AreaInfoEnum {

    AREA_ONE("1","亭湖区"),
    AREA_TWO("2","盐都区"),
    AREA_THREE("3","大丰区"),
    AREA_FOUR("4","建湖县"),
    AREA_FIVE("5","射阳县"),
    AREA_SIX("6","阜宁县"),
    AREA_SEVEN("7","滨海县"),
    AREA_EIGHT("8","响水县"),
    AREA_NINE("9","东台市"),
    AREA_TEN("10","市开发区"),
    AREA_ELE("11","盐城高新区"),
    AREA_THV("12","盐南高新区");
    private String code;
    private String name;

    AreaInfoEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String getCodeByName(String name) {
        if ("亭湖区".startsWith(name)) {
            return AreaInfoEnum.AREA_ONE.code;
        }
        if ("盐都区".startsWith(name)) {
            return AreaInfoEnum.AREA_TWO.code;
        }
        if ("大丰区".startsWith(name)) {
            return AreaInfoEnum.AREA_THREE.code;
        }
        if ("建湖县".startsWith(name)) {
            return AreaInfoEnum.AREA_FOUR.code;
        }
        if ("射阳县".startsWith(name)) {
            return AreaInfoEnum.AREA_FIVE.code;
        }
        if ("阜宁县".startsWith(name)) {
            return AreaInfoEnum.AREA_SIX.code;
        }
        if ("滨海县".startsWith(name)) {
            return AreaInfoEnum.AREA_SEVEN.code;
        }
        if ("响水县".startsWith(name)) {
            return AreaInfoEnum.AREA_EIGHT.code;
        }
        if ("东台市".startsWith(name)) {
            return AreaInfoEnum.AREA_NINE.code;
        }
        if ("市开发区".startsWith(name)) {
            return AreaInfoEnum.AREA_TEN.code;
        }
        if ("盐城高新区".startsWith(name)) {
            return AreaInfoEnum.AREA_ELE.code;
        }
        if ("盐南高新区".startsWith(name)) {
            return AreaInfoEnum.AREA_THV.code;
        }
        return "";
    }

    public static String getNameByCode(String code) {
        if (code.equals("1")) {
            return AreaInfoEnum.AREA_ONE.getName();
        }
        if (code.equals("2")) {
            return AreaInfoEnum.AREA_TWO.getName();
        }
        if (code.equals("3")) {
            return AreaInfoEnum.AREA_THREE.getName();
        }
        if (code.equals("4")) {
            return AreaInfoEnum.AREA_FOUR.getName();
        }
        if (code.equals("5")) {
            return AreaInfoEnum.AREA_FIVE.getName();
        }
        if (code.equals("6")) {
            return AreaInfoEnum.AREA_SIX.getName();
        }
        if (code.equals("7")) {
            return AreaInfoEnum.AREA_SEVEN.getName();
        }
        if (code.equals("8")) {
            return AreaInfoEnum.AREA_EIGHT.getName();
        }
        if (code.equals("9")) {
            return AreaInfoEnum.AREA_NINE.getName();
        }
        if (code.equals("10")) {
            return AreaInfoEnum.AREA_TEN.getName();
        }
        if (code.equals("11")) {
            return AreaInfoEnum.AREA_ELE.getName();
        }
        if (code.equals("12")) {
            return AreaInfoEnum.AREA_THV.getName();
        }
        return "未知类型";
    }
}
