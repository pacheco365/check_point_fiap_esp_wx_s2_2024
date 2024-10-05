/* 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * Grupo: BioRLE
 * Autores: 
 *      - Gabriel Pacheco            -   RM550191
 *      - Gustavo Veríssimo          -   RM551244
 *      - Murilo Henrique Obinata    -   RM99855
 *      - Leonardo Correia Moura     -   RM550413
 */

package br.com.fiap.twoespwx.libunclepresser;


public class App 
{
    public static void main(String[] args) {
        String inputFilePath = args[0];
        String outputFilePath = args[1];

        try {
            String sequence = readFile(inputFilePath);

            String compressedSequence = compressRLE(sequence);

            writeFile(outputFilePath, compressedSequence);

            displayReport(sequence, compressedSequence);
        } catch (IOException e) {
            System.err.println("Erro ao processar os arquivos: " + e.getMessage());
        }
    }
    
    public static String compressRLE(String sequence) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 0; i < sequence.length(); i++) {
            if (i == sequence.length() - 1 || sequence.charAt(i) != sequence.charAt(i + 1)) {
                compressed.append(sequence.charAt(i)).append(count);
                count = 1;
            } else {
                count++;
            }
        }
        return compressed.toString();
    }
}
