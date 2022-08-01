package P2

object Main {
  val bucket = "d6p2"//hardcode AWS bucket name
  val session = new spark()
  def main(args: Array[String]): Unit = {

    session.logger.info("test")/////usage of logger example
    //P2tempviews.CreateTemp()

    val test = session.spark.read.format("csv").option("header", "true").load(s"s3a://p3-testbucket/DECENNIALPL2020.P1-2022-07-29T181153.csv")
    test.show()

    val df1 = session.spark.read.format("csv").option("header", "true").load(s"s3a://$bucket/time_series_covid_19_confirmed.csv") // File location in hdfs
    df1.show()



  }

}