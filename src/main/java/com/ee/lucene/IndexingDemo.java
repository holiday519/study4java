package com.ee.lucene;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
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
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class IndexingDemo {

	public static void main(String[] args) throws IOException {
//		setUp();
		find("content", "两天");
	}

	private static void setUp() throws IOException {
		Analyzer analyzer = new IKAnalyzer();
		Directory wd = FSDirectory.open(Paths.get("indexDir"));
		IndexWriterConfig conf = new IndexWriterConfig(analyzer);
		IndexWriter indexWriter = new IndexWriter(wd, conf);
		List<String> lines = FileUtils.readLines(new File("lucene/doc.txt"));
		for (String line : lines) {
			String[] elems = line.split("\t");
			Document doc = new Document();
			IndexableField field = new StringField("id", elems[0], Store.YES);
			IndexableField title = new StringField("title", elems[1], Store.YES);
			IndexableField content = new TextField("content", elems[2], Store.NO);
			doc.add(field);
			doc.add(title);
			doc.add(content);
			indexWriter.addDocument(doc);
		}
		indexWriter.close();
	}
	
	private static void find(String key, String val) throws IOException {
		Directory rd = FSDirectory.open(Paths.get("indexDir"));
		IndexReader indexReader = DirectoryReader.open(rd);
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		Query query = new TermQuery(new Term(key, val));
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
