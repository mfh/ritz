{:codox {:codox {:writer codox-md.writer/write-docs
                 :output-dir "../doc/0.4/swank/api"}
         :dependencies [[codox-md "0.1.0"]]
         :pedantic :warn}
 :marginalia {:pedantic :warn
              :dir "../doc/0.4/swank/source"}}