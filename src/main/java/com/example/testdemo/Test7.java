package com.example.testdemo;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 聂旸
 * @date 2025/03/17
 */
public class Test7 {
    public static void main(String[] args) {
        String javascriptCode = "    var ref = document.referrer;\n" +
                "    var locationHref = window.location.href;\n" +
                "    if(locationHref.indexOf(\"fileCallBack\") != -1){\n" +
                "        function Base64() {\n" +
                "\n" +
                "            // private property\n" +
                "            _keyStr = \"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=\";\n" +
                "\n" +
                "            // public method for encoding\n" +
                "            this.encode = function (input) {\n" +
                "                var output = \"\";\n" +
                "                var chr1, chr2, chr3, enc1, enc2, enc3, enc4;\n" +
                "                var i = 0;\n" +
                "                input = _utf8_encode(input);\n" +
                "                while (i < input.length) {\n" +
                "                    chr1 = input.charCodeAt(i++);\n" +
                "                    chr2 = input.charCodeAt(i++);\n" +
                "                    chr3 = input.charCodeAt(i++);\n" +
                "                    enc1 = chr1 >> 2;\n" +
                "                    enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);\n" +
                "                    enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);\n" +
                "                    enc4 = chr3 & 63;\n" +
                "                    if (isNaN(chr2)) {\n" +
                "                        enc3 = enc4 = 64;\n" +
                "                    } else if (isNaN(chr3)) {\n" +
                "                        enc4 = 64;\n" +
                "                    }\n" +
                "                    output = output +\n" +
                "                            _keyStr.charAt(enc1) + _keyStr.charAt(enc2) +\n" +
                "                            _keyStr.charAt(enc3) + _keyStr.charAt(enc4);\n" +
                "                }\n" +
                "                return output;\n" +
                "            }\n" +
                "\n" +
                "            // public method for decoding\n" +
                "            this.decode = function (input) {\n" +
                "                var output = \"\";\n" +
                "                var chr1, chr2, chr3;\n" +
                "                var enc1, enc2, enc3, enc4;\n" +
                "                var i = 0;\n" +
                "                input = input.replace(/[^A-Za-z0-9\\+\\/\\=]/g, \"\");\n" +
                "                while (i < input.length) {\n" +
                "                    enc1 = _keyStr.indexOf(input.charAt(i++));\n" +
                "                    enc2 = _keyStr.indexOf(input.charAt(i++));\n" +
                "                    enc3 = _keyStr.indexOf(input.charAt(i++));\n" +
                "                    enc4 = _keyStr.indexOf(input.charAt(i++));\n" +
                "                    chr1 = (enc1 << 2) | (enc2 >> 4);\n" +
                "                    chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);\n" +
                "                    chr3 = ((enc3 & 3) << 6) | enc4;\n" +
                "                    output = output + String.fromCharCode(chr1);\n" +
                "                    if (enc3 != 64) {\n" +
                "                        output = output + String.fromCharCode(chr2);\n" +
                "                    }\n" +
                "                    if (enc4 != 64) {\n" +
                "                        output = output + String.fromCharCode(chr3);\n" +
                "                    }\n" +
                "                }\n" +
                "                output = _utf8_decode(output);\n" +
                "                return output;\n" +
                "            }\n" +
                "\n" +
                "            // private method for UTF-8 encoding\n" +
                "            _utf8_encode = function (string) {\n" +
                "                string = string.replace(/\\r\\n/g,\"\\n\");\n" +
                "                var utftext = \"\";\n" +
                "                for (var n = 0; n < string.length; n++) {\n" +
                "                    var c = string.charCodeAt(n);\n" +
                "                    if (c < 128) {\n" +
                "                        utftext += String.fromCharCode(c);\n" +
                "                    } else if((c > 127) && (c < 2048)) {\n" +
                "                        utftext += String.fromCharCode((c >> 6) | 192);\n" +
                "                        utftext += String.fromCharCode((c & 63) | 128);\n" +
                "                    } else {\n" +
                "                        utftext += String.fromCharCode((c >> 12) | 224);\n" +
                "                        utftext += String.fromCharCode(((c >> 6) & 63) | 128);\n" +
                "                        utftext += String.fromCharCode((c & 63) | 128);\n" +
                "                    }\n" +
                "\n" +
                "                }\n" +
                "                return utftext;\n" +
                "            }\n" +
                "\n" +
                "            // private method for UTF-8 decoding\n" +
                "            _utf8_decode = function (utftext) {\n" +
                "                var string = \"\";\n" +
                "                var i = 0;\n" +
                "                var c = c1 = c2 = 0;\n" +
                "                while ( i < utftext.length ) {\n" +
                "                    c = utftext.charCodeAt(i);\n" +
                "                    if (c < 128) {\n" +
                "                        string += String.fromCharCode(c);\n" +
                "                        i++;\n" +
                "                    } else if((c > 191) && (c < 224)) {\n" +
                "                        c2 = utftext.charCodeAt(i+1);\n" +
                "                        string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));\n" +
                "                        i += 2;\n" +
                "                    } else {\n" +
                "                        c2 = utftext.charCodeAt(i+1);\n" +
                "                        c3 = utftext.charCodeAt(i+2);\n" +
                "                        string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));\n" +
                "                        i += 3;\n" +
                "                    }\n" +
                "                }\n" +
                "                return string;\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        var resultJson ='\"{\\\"file_name\\\":\\\"100.png\\\",\\\"width\\\":37,\\\"width_dpi\\\":96,\\\"height\\\":32,\\\"height_dpi\\\":96,\\\"fileType\\\":\\\"png\\\",\\\"fileCategory\\\":\\\"图片文件\\\",\\\"file_size\\\":15456,\\\"key\\\":[\\\"4f95df42d2417b2318c6782c7f00e517\\\"],\\\"success\\\":true}\";\n" +
                "        var referrer = ref.split(\"/\");\n" +
                "        var r2 = [];\n" +
                "        for (var i = 0; i < referrer.length; i++) {\n" +
                "            if (referrer[i] != \"http:\" && referrer[i] != 'https:' && referrer[i] != \"\") {\n" +
                "                r2.push(referrer[i])\n" +
                "            }\n" +
                "        }\n" +
                "        var domain = r2[0];\n" +
                "\n" +
                "        var doc = document;\n" +
                "        var iframe = doc.createElement(\"iframe\");\n" +
                "        var b = new Base64();\n" +
                "        resultJson = b.encode(resultJson);\n" +
                "        var src = referrer[0] + \"//\" + domain + \"/fileCallBack?t=\" + resultJson;\n" +
                "        iframe.setAttribute(\"src\", src);\n" +
                "        doc.body.appendChild(iframe);\n" +
                "    }else{\n" +
                "        window.name = '{\"file_name\":\"100.png\",\"width\":37,\"width_dpi\":96,\"height\":32,\"height_dpi\":96,\"fileType\":\"png\",\"fileCategory\":\"图片文件\",\"file_size\":15456,\"key\":[\"4f95df42d2417b2318c6782c7f00e517\"],\"success\":true}';\n" +
                "    }";

        // 定义正则表达式
        if (javascriptCode.contains("window.name")) {
            System.out.println("fff");
        }
        Pattern pattern = Pattern.compile("window.name \\s*=\\s*('|\")(.*)('|\")");
        Matcher matcher = pattern.matcher(javascriptCode);

        if (matcher.find()) {
            String value = matcher.group(2);
            System.out.println("window.name 的值为: " + value);
        } else {
            System.out.println("未找到 window.name 的赋值语句");
        }
    }

}
