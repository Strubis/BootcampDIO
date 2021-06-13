using CovidAPI.Data.Collections;
using Microsoft.Extensions.Configuration;
using MongoDB.Bson.Serialization;
using MongoDB.Bson.Serialization.Conventions;
using MongoDB.Driver;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CovidAPI.Data
{
    public class MongoDB
    {
        public IMongoDatabase Database { get; }

        public MongoDB(IConfiguration configuration)
        {
            try
            {
                var settings = MongoClientSettings.FromUrl(
                    new MongoUrl(configuration["ConnectionString"]));
                var client = new MongoClient(settings);
                Database = client.GetDatabase(configuration["NameDatabase"]);

                MapClasses();

            }catch(Exception ex)
            {
                throw new MongoException("It was not possible to connect to MongoDB", ex);
            }
        }

        private void MapClasses()
        {
            var conventionPack = new ConventionPack { new CamelCaseElementNameConvention() };
            ConventionRegistry.Register("camelCase", conventionPack, t => true);

            if (!BsonClassMap.IsClassMapRegistered(typeof(Curado)))
            {
                BsonClassMap.RegisterClassMap<Curado>(c =>
                {
                    c.AutoMap();
                    c.SetIgnoreExtraElements(true);
                });
            }

        }
    }
}
