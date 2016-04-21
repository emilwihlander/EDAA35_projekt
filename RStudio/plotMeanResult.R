# function  for  plotting  data
getMean = function(file , start = 1) {
  data  <- read.csv(file)
  mean <- sum(data)/(nrow(data))
  return(mean)
}

plotMean = function(times = 1) {
  counter <- 0
  mean <- NULL
  while(times > counter) {
    
    setwd("/h/d9/j/dat15jh1/github/EDAA35_projekt/bin/")
    system(terminal)
    setwd("/h/d9/j/dat15jh1/github/EDAA35_projekt")
    
    mean <- c(mean, getMean(output, start = 1))
    counter <- counter+1
    print(counter)
  }
  rows <- c(1:times)
  frame <- data.frame(rows, mean)
  
  meanOfMean <- round(sum(mean)/times)
  medianOfMean <- round(median(mean, na.rm=FALSE))
  subtitle <- paste("Mean = ",meanOfMean,"ns. Median = ",medianOfMean,"ns.", sep="")
  plot(frame, type = "l",ylab="Mean", xlab="Iteration", sub=subtitle, font.lab=2)
}

inputFil <- "almost_sorted_2000"
sort <- "insertionSort"
iter <- "600"
times <- 100
terminal <- paste("java Algorithms ../input/", inputFil, " ", sort, " ", iter, sep="")
output <- paste("output/", paste(sort, inputFil, iter, sep="_"), sep="")

#plotMean(times = times)
pdf(paste(output,"_",times,".pdf",sep=""))
plotMean(times = times) # plot to pdf  file
dev.off()