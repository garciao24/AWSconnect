import com.amazonaws.services.s3.model.GetObjectRequest

import java.io.File

object Main {
  val bucket = "testbucketoscariamyes" //hardcode AWS bucket name
  val session = new spark()

  def main(args: Array[String]): Unit = {

    session.logger.info("test") /////usage of logger example
    //P2tempviews.CreateTemp()

    val df1 = session.spark.read.format("csv").option("header", "true").load(s"s3a://covidanalysis/Data_setP2/covid_19_data.csv")
    //df1.show()


//    val df1 = session.spark.read.format("csv").option("header", "true").load(s"s3a://d6p2/time_series_covid_19_confirmed.csv") // File location in hdfs
//    df1.show()

    file.outputJson("covidtest",df1)

    //df1.write.mode("Overwrite").csv("s3a://testbuckscala/testt222")

    val filetype = "json"

    session.client.createBucket(bucket)
    session.client.putObject(bucket,s"testfolder/test.$filetype",new File(s"C:\\output"+s"$filetype"+s"AWS\\covidtest.$filetype"))
    println(session.client.getUrl(bucket,s"testfolder/test.$filetype"))
    session.client.getObject(new GetObjectRequest(bucket, s"testfolder/test.$filetype"),
      (new File(s"testfolder/test.$filetype")))

    val df = session.spark.read.format(s"$filetype").option("header", "true").load(s"s3a://$bucket/testfolder/test.$filetype") // File location in hdfs
    df.show()


  }

}
