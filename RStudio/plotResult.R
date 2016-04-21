# function  for  plotting  data
plotresult = function(file , start = 1) {
  data  <- read.csv(file)
  data  <- data[start:nrow(data) ,]
  plot(data , type = 'l')
  
}

inputFil <- "Random_2000"
sort <- "bubbleSort"
iter <- "600"
terminal <- paste("java Algorithms ../input/", inputFil, " ", sort, " ", iter, sep="")
output <- paste("output/", paste(sort, inputFil, iter, sep="_"), sep="")

setwd("/h/d9/j/dat15jh1/github/EDAA35_projekt/bin/")
system(terminal)
setwd("/h/d9/j/dat15jh1/github/EDAA35_projekt")

plotresult(output, start=1) # plot to  screent
pdf(paste(output,".pdf",sep=""))
plotresult(output, start=1) # plot to pdf  file
dev.off()