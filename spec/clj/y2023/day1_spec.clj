(ns y2023.day1-spec
  (:require [speclj.core :refer :all]
            [y2023.day1 :as sut]))

(describe "day 1"

  (context "part 1"
    (context "parser"

      (context "for line"

        (it "finds value with numbers at beginning and end"
          (should= 12 (sut/parse-ln "1abc2")))

        (it "finds value with numbers inside line"
          (should= 38 (sut/parse-ln "pqr3stu8vwx")))

        (it "finds value with more than 2 numbers"
          (should= 15 (sut/parse-ln "a1b2c3d4e5f")))

        (it "finds value with single number"
          (should= 77 (sut/parse-ln "treb7uchet"))))

      (context "for file"

        (it "finds value for each line"
          (should= [12 38 15 77] (sut/parse-file "1abc2\npqr3stu8vwx\na1b2c3d4e5f\ntreb7uchet"))))))

  (context "part 2"
    ))