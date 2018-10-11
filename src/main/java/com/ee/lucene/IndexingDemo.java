package com.ee.lucene;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class IndexingDemo {

	public static void main(String[] args) throws IOException, ParseException {
//		Analyzer analyzer = new StandardAnalyzer();
		Analyzer analyzer = new IKAnalyzer();
		
		Directory wd = FSDirectory.open(Paths.get("indexDir"));
		IndexWriterConfig conf = new IndexWriterConfig(analyzer);
		IndexWriter indexWriter = new IndexWriter(wd, conf);
		Document doc1 = new Document();
		IndexableField field1 = new StringField("id", "1", Store.YES);
		IndexableField title1 = new StringField("title", "java培训零基础开始 从入门到精通", Store.YES);
		IndexableField content1 = new TextField("content",
				"java培训，中软国际独创实训模式，三免一终身，学java多项保障让您无后顾之忧。中软国际java培训，全日制教学，真实项目实战，名企定制培训，四个月速成java工程师!", Store.YES);
		doc1.add(field1);
		doc1.add(title1);
		doc1.add(content1);
		indexWriter.addDocument(doc1);

		Document doc2 = new Document();
		IndexableField field2 = new StringField("id", "2", Store.YES);
		IndexableField title2 = new StringField("title", "创业板新低年内上涨股不足百只 抗跌英雄仅剩11只", Store.YES);
		IndexableField content2 = new TextField("content",
				"短短两天，创业板再度陷入窘境。昨日创业板指创四年来新低，成交额再度跌破400亿元，与此同时，年内股价上涨的创业板股仅剩64只。", Store.YES);
		doc2.add(field2);
		doc2.add(title2);
		doc2.add(content2);
		indexWriter.addDocument(doc2);
		indexWriter.close();

		
		/***************************************************************************************************************/
		Directory rd = FSDirectory.open(Paths.get("indexDir"));
		IndexReader indexReader = DirectoryReader.open(rd);
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		Query query = new TermQuery(new Term("content", "培训"));
		TopDocs topDocs = indexSearcher.search(query, 10);
		System.out.println("总记录数：" + topDocs.totalHits);
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		for (ScoreDoc scoreDoc : scoreDocs) {
			System.out.println("相关度得分：" + scoreDoc.score);
			int d = scoreDoc.doc;
			Document document = indexSearcher.doc(d);
			System.out.println(document.get("id"));
			System.out.println(document.get("title"));
			System.out.println(document.get("content"));
		}
		indexReader.close();
	}

}
