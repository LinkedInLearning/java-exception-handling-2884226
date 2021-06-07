package com.cecilireid.fibonacci;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("fibonacci")
public class FibonacciController {

    /**
     * Determine the n-th fibonacci number
     *
     * @param n position of the fibonacci number requested
     * @return the n-th fibonacci number in the sequence
     */
    @GetMapping("findNumber")
    public ResponseEntity<String> findFibonacciNumber(@RequestParam int n) {
        int fibNum;
        try {
            fibNum = fibonacci(n);
        } catch (FibonacciOutOfRangeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(String.valueOf(fibNum));
    }

    /**
     * Store the first n-th numbers in the fibonacci sequence in a text file.
     *
     * @param n position in fibonacci sequence
     * @return name of the file created
     */
    @PostMapping("createSequence")
    public ResponseEntity<String> generateFibonacciSequence(@RequestParam String n) {
        List<Integer> sequence;
        try {
            sequence = getSequence(n);
        } catch (FibonacciInputException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        String fileName;
        try {
            fileName = storeSequence(sequence);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.ok(fileName);
    }

    @GetMapping("getSequence")
    public ResponseEntity<String> retrieveFibonacciSequence(@RequestParam String fileName) {
        String sequence;
        try {
            sequence = getSequenceByFilename(fileName);
        } catch (FileNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found. Please check request and try again " + e.getMessage());
        }
        return ResponseEntity.ok(sequence);
    }

    /**
     * Determine the golden ratio for given index in array
     *
     * @param n position of the fibonacci number requested
     * @return the golden ratio between n index and n-1 index
     */
    @GetMapping("findRatio")
    public ResponseEntity<String> getRatio(@RequestParam int n) throws FibonacciOutOfRangeException {
        int dividend = fibonacci(n);
        int divisor = fibonacci(n-1);
        return ResponseEntity.ok(String.valueOf(dividend / divisor));
    }

    private String getSequenceByFilename(String filename) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        return reader.lines().collect(Collectors.joining());
    }

    /**
     * Generate fibonacci sequence without using recursion
     *
     * @param str number of numbers that should be included in the fibonacci sequence
     * @return list of integers with fibonacci sequence
     */
    private List<Integer> getSequence(String str) throws FibonacciInputException {
        int n;
        try {
            n = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new FibonacciInputException("Invalid input. Please provide a valid number");
        }
        List<Integer> sequence = new ArrayList<>();
        sequence.add(0);
        int prev = 0;
        int curr = 1;
        int index = 1;
        while (index <= n) {
            sequence.add(curr);
            int next = prev + curr;
            prev = curr;
            curr = next;
            index++;
        }
        return sequence;
    }

    /**
     * Save the fibonacci sequence in a txt file
     *
     * @param sequence list of ints in the fibonacci sequence
     * @return String name of the file saved
     */
    private String storeSequence(List<Integer> sequence) throws IOException {
        String name = "fibonacci.txt";
        File file = new File(name);

        // creates the file
        file.createNewFile();

        // creates a FileWriter Object
        FileWriter writer = new FileWriter(file);

        // Writes the content to the file
        writer.write(sequence.toString());
        writer.flush();
        writer.close();
        return name;
    }

    /**
     * Recursively find the Fibonacci number at the position in the sequence
     *
     * @param position requested position of fibonacci sequence (i.e. 8th number in sequence)
     * @return fibonacci number at position (i.e. 21)
     */
    private int fibonacci(int position) throws FibonacciOutOfRangeException {
        if (position <= 1) {
            return position;
        }
        if (position >= 8) {
            throw new FibonacciOutOfRangeException(String.format("Requested position %s is too large. Please try again.", position));
        }
        return fibonacci(position - 1) + fibonacci(position - 2);
    }

}
