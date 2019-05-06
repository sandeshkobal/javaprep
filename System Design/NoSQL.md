[EXPLORING THE DIFFERENT TYPES OF NOSQL DATABASES PART II](https://www.3pillarglobal.com/insights/exploring-the-different-types-of-nosql-databases)

<h1 class="article-title blue">Exploring the Different Types of NoSQL Databases Part ii</h1></div><div class="large-4 medium-4 columns">
<a class="mail-icon-button show-for-medium-up" href=/contact><i class='entypo mail'></i></a></div></div><div class=featured-images></div><div class=remove-margin><p>In our previous post titled ‘Just Say Yes to NoSQL’, we cited the CAP theorem, did a point-by-point comparison between RDBMS and NoSQL and explored in-depth, the various characteristics of NoSQL which make it the most reliable database solution available today.</p><p>In this second part of the 3-part series we will focus exclusively on the different types of NoSQL databases.</p><p><strong>Types of NoSQL databases- </strong></p><p>There are 4 basic types of NoSQL databases:</p><ol><li><strong>Key-Value Store</strong> &#8211; It has a Big Hash Table of keys &amp; values {Example- Riak, Amazon S3 (Dynamo)}</li><li><strong>Document-based</strong> <strong>Store- It </strong>stores documents made up of tagged elements. {Example- CouchDB}</li><li><strong>Column-based Store- </strong>Each storage block contains data from only one column, {Example- HBase, Cassandra}</li><li><strong>Graph-based</strong>-A network database that uses edges and nodes to represent and store data. {Example- Neo4J}</li></ol><p>1. <strong>Key Value Store NoSQL Database</strong></p><p>The schema-less format of a key value database like Riak is just about what you need for your storage needs. The key can be synthetic or auto-generated while the value can be String, JSON, BLOB (basic large object) etc.</p><p>The key value type basically, uses a hash table in which there exists a unique key and a pointer to a particular item of data. A bucket is a logical group of keys &#8211; but they don’t physically group the data. There can be identical keys in different buckets.</p><p>Performance is enhanced to a great degree because of the cache mechanisms that accompany the mappings. To read a value you need to know both the key and the bucket because the real key is a hash (Bucket+ Key).</p><p>There is no complexity around the Key Value Store database model as it can be implemented in a breeze. Not an ideal method if you are only looking to just update part of a value or query the database.</p><p>When we try and reflect back on the CAP theorem, it becomes quite clear that key value stores are great around the Availability and Partition aspects but definitely lack in Consistency.</p><p>Example: Consider the data subset represented in the following table. Here the key is the name of the 3Pillar country name, while the value is a list of addresses of 3PiIllar centers in that country.</p><table class=table-style style="width: 500px;" border=1 cellspacing=1 cellpadding=1><tbody><tr><td class=rtecenter><strong>Key</strong></td><td class=rtecenter><strong>Value</strong></td></tr><tr><td class=rtecenter>&#8220;India&#8221;</td><td class=rtecenter>{&#8220;B-25, Sector-58, Noida, India &#8211; 201301&#8221;</td></tr><tr><td class=rtecenter>&#8220;Romania&#8221;</td><td class=rtecenter>{&#8220;IMPS Moara Business Center, Buftea No. 1, Cluj-Napoca, 400606&#8243;,City Business Center, Coriolan Brediceanu No. 10, Building B, Timisoara, 300011&#8221;}</td></tr><tr><td class=rtecenter>&#8220;US&#8221;</td><td class=rtecenter>{&#8220;3975 Fair Ridge Drive. Suite 200 South, Fairfax, VA 22033&#8221;}</td></tr></tbody></table><p>The key can be synthetic or auto-generated while the value can be String, JSON, BLOB (basic large object) etc.</p><p>This key/value type database allow clients to read and write values using a key as follows:</p><ul><li>Get(key), returns the value associated with the provided key.</li><li>Put(key, value), associates the value with the key.</li><li>Multi-get(key1, key2, .., keyN), returns the list of values associated with the list of keys.</li><li>Delete(key), removes the entry for the key from the data store.</li></ul><p>While Key/value type database seems helpful in some cases, but it has some weaknesses as well. One, is that the model will not provide any kind of traditional database capabilities (such as atomicity of transactions, or consistency when multiple transactions are executed simultaneously). Such  capabilities must be provided by the application itself.</p><p>Secondly, as the volume of data increases, maintaining unique values as keys may become more difficult; addressing this issue requires the introduction of some complexity in generating character strings that will remain unique among an extremely large set of keys.</p><ul><li>Riak and <a href=http://en.wikipedia.org/wiki/Amazon_DynamoDB target=_blank>Amazon’s Dynamo</a> are the most popular key-value store NoSQL databases.</li></ul><p>2. <strong>Document Store NoSQL Database</strong></p><p>The data which is a collection of key value pairs is compressed as a document store quite similar to a key-value store, but the only difference is that the values stored (referred to as “documents”) provide some structure and encoding of the managed data. XML, JSON (Java Script Object Notation), BSON (which is a binary encoding of JSON objects) are some common standard encodings.</p><p>The following example shows data values collected as a “document” representing the names of specific retail stores. Note that while the three examples all represent locations, the representative models are different.</p><pre class=brush:java;>{officeName:”3Pillar Noida”, 
{Street: “B-25, City:”Noida”, State:”UP”, Pincode:”201301”}
}
{officeName:”3Pillar Timisoara”,
{Boulevard:”Coriolan Brediceanu No. 10”, Block:”B, Ist Floor”, City: “Timisoara”, Pincode: 300011”}
}
{officeName:”3Pillar Cluj”,
{Latitude:”40.748328”, Longitude:”-73.985560”}
}
</pre><p>One key difference between a key-value store and a document store is that the latter embeds attribute metadata associated with stored content, which essentially provides a way to query the data based on the contents. For example, in the above example, one could search for all documents in which “City” is “Noida” that would deliver a result set containing all documents associated with any “3Pillar Office” that is in that particular city.</p><p><a href=http://en.wikipedia.org/wiki/CouchDB target=_blank>Apache CouchDB</a> is an example of a document store. CouchDB uses <a href=http://en.wikipedia.org/wiki/JSON target=_blank>JSON</a> to store data, <a href=http://en.wikipedia.org/wiki/JavaScript target=_blank>JavaScript</a> as its query language using <a href=http://en.wikipedia.org/wiki/MapReduce>MapReduce</a> and <a href=http://en.wikipedia.org/wiki/HTTP target=_blank>HTTP</a> for an <a href=http://en.wikipedia.org/wiki/API target=_blank>API</a>.  Data and relationships are not stored in tables as is a norm with conventional relational databases but in fact are a collection of independent documents.</p><p>The fact that document style databases are schema-less makes adding fields to JSON documents a simple task without having to define changes first.</p><ul><li>Couchbase and MongoDB are the most popular document based databases.</li></ul><p>3. <strong>Column Store NoSQL Database</strong>&#8211;</p><p>In column-oriented NoSQL database, data is stored in cells grouped in columns of data rather than as rows of data. Columns are logically grouped into column families. Column families can contain a virtually unlimited number of columns that can be created at runtime or the definition of the schema. Read and write is done using columns rather than rows.</p><p>In comparison, most relational DBMS store data in rows, the benefit of storing data in columns, is fast search/ access and data aggregation. Relational databases store a single row as a continuous disk entry. Different rows are stored in different places on disk while Columnar databases store all the cells corresponding to a column as a continuous disk entry thus makes the search/access faster.</p><p>For example:   To query the titles from a bunch of a million articles will be a painstaking task while using relational databases as it will go over each location to get item titles. On the other hand, with just one disk access, title of all the items can be obtained.</p><p><strong>Data Model </strong></p><ul><li><strong>ColumnFamily</strong>:  ColumnFamily is a single structure that can group Columns and SuperColumns with ease.</li><li><strong>Key</strong>: the permanent name of the record. Keys have different numbers of columns, so the database can scale in an irregular way.</li><li><strong>Keyspace</strong>:  This defines the outermost level of an organization, typically the name of the application. For example, ‘3PillarDataBase&#8217; (database name).</li><li><strong>Column</strong>:  It has an ordered list of elements aka tuple with a name and a value defined.</li></ul><p>The best known examples are Google’s BigTable and HBase &amp; Cassandra that were inspired from BigTable.</p><p>BigTable, for instance is a high performance, compressed and proprietary data storage system owned by Google. It has the following attributes:</p><ul><li><strong>Sparse </strong>– some cells can be empty</li><li><strong>Distributed </strong>– data is partitioned across many hosts</li><li><strong>Persistent </strong>– stored to disk</li><li><strong>Multidimensional </strong>– more than 1 dimension</li><li><strong>Map </strong>– key and value</li><li><strong>Sorted </strong>– maps are generally not sorted but this one is</li></ul><p>A 2-dimensional table comprising of rows and columns is part of the relational database system.</p><table class=table-style style="width: 500px;" border=1 cellspacing=1 cellpadding=1><tbody><tr><td class=rtecenter><strong>City</strong></td><td class=rtecenter><strong>Pincode</strong></td><td class=rtecenter><strong>Strength</strong></td><td class=rtecenter><strong>Project</strong></td></tr><tr><td class=rtecenter>Noida</td><td class=rtecenter>201301</td><td class=rtecenter>250</td><td class=rtecenter>20</td></tr><tr><td class=rtecenter>Cluj</td><td class=rtecenter>400606</td><td class=rtecenter>200</td><td class=rtecenter>15</td></tr><tr><td class=rtecenter>Timisoara</td><td class=rtecenter>300011</td><td class=rtecenter>150</td><td class=rtecenter>10</td></tr><tr><td class=rtecenter>Fairfax</td><td class=rtecenter>VA 22033</td><td class=rtecenter>100</td><td class=rtecenter>5</td></tr></tbody></table><p>For above RDBMS table a BigTable map can be visualized as shown below.</p><pre class=brush:java;>{
3PillarNoida: {
city: Noida
pincode: 201301
},
details: {
strength: 250
projects: 20
}
}
{
3PillarCluj: {
address: {
city: Cluj
pincode: 400606
}, 
details: {
strength: 200
projects: 15
}
},
{
3PillarTimisoara: {
address: {
city: Timisoara
pincode: 300011
},
details: {
strength: 150
projects: 10
}
}
{
3PillarFairfax : {
address: {
city: Fairfax
pincode: VA 22033
}, 
details: {
strength: 100
projects: 5
}
}

</pre><ul><li>The outermost keys 3PillarNoida, 3PillarCluj, 3PillarTimisoara and 3PillarFairfax are analogues to rows.</li><li>‘address’ and ‘details’ are called <strong>column families</strong>.</li><li>The column-family ‘address’ has <strong>columns </strong>‘city’ and ‘pincode’.</li><li>The column-family details’ has <strong>columns </strong>‘strength’ and ‘projects’.</li></ul><p>Columns can be referenced using CloumnFamily.</p><ul><li>Google’s BigTable, HBase and Cassandra are the most popular column store based databases.</li></ul><p>4. <strong>Graph Base NoSQL Database</strong></p><p>In a Graph Base NoSQL Database, you will not find the rigid format of SQL or the tables and columns representation, a flexible graphical representation is instead used which is perfect to address scalability concerns. Graph structures are used with edges, nodes and properties which provides index-free adjacency. Data can be easily transformed from one model to the other using a Graph Base NoSQL database.</p>
<img style="width: 300px; height: 372px;" src=/sites/default/files/xnosql-2c.png.pagespeed.ic.4ooXFj1Eso.webp alt="Graph Base NoSQL database"><ul><li>These databases that uses edges and nodes to represent and store data.</li><li>These nodes are organised by some relationships with one another, which is represented by edges between the nodes.</li><li>Both the nodes and the relationships have some defined properties.</li></ul>
<img src=/sites/default/files/xnosql-2d.png.pagespeed.ic.GI9la3q3EV.webp alt="graph based database"><p>The following are some of the features of the graph based database, which are explained on the basis of the example below:</p><p>Labeled, directed, attributed multi-graph : The graphs contains the nodes which are labelled properly with some properties and these nodes have some relationship with one another which is shown by the directional edges. For example: in the following representation, “Alice knows Bob”  is shown by an edge that also has some properties.</p><p>While relational database models can replicate the graphical ones, the edge would require a join which is a costly proposition.</p><p><img src=/sites/default/files/xnosql-2e.png.pagespeed.ic.1pJG53yhFu.webp alt="database models"><br>
<strong>UseCase</strong>&#8211;</p><p>Any ‘Recommended for You’ rating you see on e-commerce websites (book/video renting sites) is often derived by taking into account how other users have rated the product in question. Arriving at such a UseCase is made easy using Graph databases.</p><p><a href=http://infogrid.org/ target=_blank>InfoGrid</a> and <a href=http://www.infinitegraph.com/ target=_blank>Infinite Graph</a> are the most popular graph based databases.  InfoGrid allows the connection of as many edges (Relationships) and nodes (MeshObjects), making it easier to represent hyperlinked and complex set of information.</p><p>There are two kinds of GraphDatabase offered by InfoGrid, these include the following:</p><p><a href=http://infogrid.org/trac/wiki/MeshBase target=_blank>MeshBase</a>&#8211;   It is a perfect option where standalone deployment is required.</p><p><a href=http://infogrid.org/trac/wiki/NetMeshBase target=_blank>NetMeshBase</a> – It is ideally suited for large distributed graphs and has additional capabilities to communicate with other similar NetMeshbase.</p><p>This concludes the second post exemplifying the value in a NoSQL implementation. In this blog post we discussed in detail the different types of NoSQL databases. Watch out for the concluding part of the series which will cover important factors to consider before finalizing which NoSQL database to use.</p></div>