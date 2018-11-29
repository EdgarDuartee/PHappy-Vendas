/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.vendas.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author ferna
 */
public class Coordenadas {

    public Coordenadas() {
    }

    private String JsonMaps, JsonModify;
    private String Latitude;
    private String Longitude;
    //API DO EDGAR    
//    private String keyApi = "AIzaSyCCXW9zJltZ4PUtT1eaAuJeA3OreLKCqgE";
    //API DO LUIZ 
//    private String keyApi = "AIzaSyClq1KlL77y-yFQg9tREoTL3RX5xHZgDN8";
    private String keyApi = "AIzaSyDcKzjKLpEcBsdcVRj4SrSMYjjiMBAGBUk";
    private boolean status;

    public void Buscar(String Numero, String Rua, String Bairro, String Cidade) {
        //Formatando os dados para o padrão da URL.
        Rua = this.FormataString(Rua);
        Bairro = this.FormataString(Bairro);
        Cidade = this.FormataString(Cidade);
        System.out.println(Rua+Bairro+Cidade+Numero);
        //ABRINDO A CONEXÃO COM O SITE, E ATRIBUINDO O CONTEÚDO BUSCADO A VARIAVEL.
        try {
            URL oracle = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=" + Numero + "+" + Rua + ",+" + Bairro + ",+" + Cidade + "&key=" + keyApi);
            BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
            String inputLine = "";
            while ((inputLine = in.readLine()) != null) {
                JsonMaps = JsonMaps + inputLine;

            }
        } catch (IOException EX) {
            System.out.println(EX);
        }
        System.out.println(JsonMaps);
    }

    public double getLatitude() {
        int pos = JsonMaps.indexOf("location");
        JsonModify = JsonMaps.substring(pos, pos + 200);
        Latitude = JsonModify;
        System.out.println(Double.parseDouble(Latitude.substring(Latitude.indexOf("lat") + 6, Latitude.indexOf(","))));
        return (Double.parseDouble(Latitude.substring(Latitude.indexOf("lat") + 6, Latitude.indexOf(","))));
    }

    public double getLongitude() {
        Longitude = JsonModify.trim();
        Longitude = Longitude.substring(Longitude.indexOf("lng") + 6, Longitude.indexOf("}"));
        System.out.println(Double.parseDouble(Longitude));
        return (Double.parseDouble(Longitude));
    }

    public boolean status() {
        if (JsonMaps.substring(JsonMaps.indexOf("status") + 11, JsonMaps.length() - 2).contains("OK")) {

            return true;
        } else {

            return false;
        }
    }

    public void Simulacao() {
        JsonMaps = "{\n"
                + "   \"results\" : [\n"
                + "      {\n"
                + "         \"address_components\" : [\n"
                + "            {\n"
                + "               \"long_name\" : \"1600\",\n"
                + "               \"short_name\" : \"1600\",\n"
                + "               \"types\" : [ \"street_number\" ]\n"
                + "            },\n"
                + "            {\n"
                + "               \"long_name\" : \"Amphitheatre Parkway\",\n"
                + "               \"short_name\" : \"Amphitheatre Pkwy\",\n"
                + "               \"types\" : [ \"route\" ]\n"
                + "            },\n"
                + "            {\n"
                + "               \"long_name\" : \"Mountain View\",\n"
                + "               \"short_name\" : \"Mountain View\",\n"
                + "               \"types\" : [ \"locality\", \"political\" ]\n"
                + "            },\n"
                + "            {\n"
                + "               \"long_name\" : \"Santa Clara County\",\n"
                + "               \"short_name\" : \"Santa Clara County\",\n"
                + "               \"types\" : [ \"administrative_area_level_2\", \"political\" ]\n"
                + "            },\n"
                + "            {\n"
                + "               \"long_name\" : \"California\",\n"
                + "               \"short_name\" : \"CA\",\n"
                + "               \"types\" : [ \"administrative_area_level_1\", \"political\" ]\n"
                + "            },\n"
                + "            {\n"
                + "               \"long_name\" : \"Estados Unidos\",\n"
                + "               \"short_name\" : \"US\",\n"
                + "               \"types\" : [ \"country\", \"political\" ]\n"
                + "            },\n"
                + "            {\n"
                + "               \"long_name\" : \"94043\",\n"
                + "               \"short_name\" : \"94043\",\n"
                + "               \"types\" : [ \"postal_code\" ]\n"
                + "            }\n"
                + "         ],\n"
                + "         \"formatted_address\" : \"1600 Amphitheatre Pkwy, Mountain View, CA 94043, EUA\",\n"
                + "         \"geometry\" : {\n"
                + "            \"location\" : {\n"
                + "               \"lat\" : 37.4222397,\n"
                + "               \"lng\" : -122.0857654\n"
                + "            },\n"
                + "            \"location_type\" : \"ROOFTOP\",\n"
                + "            \"viewport\" : {\n"
                + "               \"northeast\" : {\n"
                + "                  \"lat\" : 37.42358868029149,\n"
                + "                  \"lng\" : -122.0844164197085\n"
                + "               },\n"
                + "               \"southwest\" : {\n"
                + "                  \"lat\" : 37.4208907197085,\n"
                + "                  \"lng\" : -122.0871143802915\n"
                + "               }\n"
                + "            }\n"
                + "         },\n"
                + "         \"place_id\" : \"ChIJ2eUgeAK6j4ARbn5u_wAGqWA\",\n"
                + "         \"plus_code\" : {\n"
                + "            \"compound_code\" : \"CWC7+VM Mountain View, California, Estados Unidos\",\n"
                + "            \"global_code\" : \"849VCWC7+VM\"\n"
                + "         },\n"
                + "         \"types\" : [ \"street_address\" ]\n"
                + "      }\n"
                + "   ],\n"
                + "   \"status\" : \"OK\"\n"
                + "}";
        JsonModify = JsonMaps;
    }

    public String FormataString(String endereco) {
        endereco = endereco.replaceAll(" ", "+");
        endereco = endereco.replaceAll("[áÁàÀâÂãÃäÄ]", "a");
        endereco = endereco.replaceAll("[éÉèÈêÊëË]", "e");
        endereco = endereco.replaceAll("[íÍìÌÎîÏï]", "i");
        endereco = endereco.replaceAll("[óÓòÒõÕôÔöÖ]", "o");
        endereco = endereco.replaceAll("[úÚùÙûÛüÜ]", "u");
        return endereco;
    }

}
